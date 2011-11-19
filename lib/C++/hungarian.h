#ifndef HUNGARIAN__
#define HUNGARIAN__

const int INF = 1000000000;
const int MAX_N = 100;

int n;
int profit[MAX_N][MAX_N];
int m1[MAX_N];
int m2[MAX_N];

void relax(int x, vi &l1, vi &l2, vi &slack, vi &slackAt)
{
	for (int y = 0; y < n; ++y) {
		int t = l1[x] + l2[y] - profit[x][y];
		if (t < slack[y]) {
			slack[y] = t;
			slackAt[y] = x;
		}
	}
}

void relabel(vi &l1, vi &l2, vector<bool> &s, vector<bool> &t, vi &slack)
{
	int delta = INF;
	for (int i = 0; i < n; ++i)
		if (!t[i])
			delta = min(delta, slack[i]);
	for (int i = 0; i < n; ++i) {
		if (s[i])
			l1[i] -= delta;
		if (t[i])
			l2[i] += delta;
		else
			slack[i] -= delta;
	}
}

void augment(vi &l1, vi &l2)
{
	// find a free vertex
	int r = -1;
	for (int i = 0; i < n; ++i)
		if (m1[i] == -1) {
			r = i;
			break;
		}

	// initialize the alternating tree
	vector<bool> s(n);
	vector<bool> t(n);
	s[r] = true;

	vi slack(n);
	vi slackAt(n);
	for (int i = 0; i < n; ++i) {
		slack[i] = l1[r] + l2[i] - profit[r][i];
		slackAt[i] = r;
	}

	vi prev(n, -1);
	prev[r] = -2;

	queue<int> q;
	q.push(r);

	int x;
	int y;
	while (true) {
		while (!q.empty()) {
			x = q.front();
			q.pop();
			for (y = 0; y < n; ++y)
				if (l1[x] + l2[y] == profit[x][y] && !t[y]) {
					int z = m2[y];
					if (z == -1)
						goto FOUND;
					t[y] = true;
					s[z] = true;
					prev[z] = x;
					q.push(z);
					relax(z, l1, l2, slack, slackAt);
				}
		}

		relabel(l1, l2, s, t, slack);

		for (y = 0; y < n; ++y)
			if (!t[y] && slack[y] == 0) {
				x = slackAt[y];
				int z = m2[y];
				if (z == -1)
					goto FOUND;
				t[y] = true;
				if (!s[z]) {
					s[z] = true;
					prev[z] = x;
					q.push(z);
					relax(z, l1, l2, slack, slackAt);
				}
			}
	}
FOUND:
	do {
		int z = m1[x];
		m1[x] = y;
		m2[y] = x;
		x = prev[x];
		y = z;
	} while (x != -2);
}

int hungarian()
{
	memset(m1, -1, sizeof(m1));
	memset(m2, -1, sizeof(m2));

	// initialize a feasible labeling
	vi l1(n);
	vi l2(n);
	for (int i = 0; i < n; ++i)
		l1[i] = *max_element(profit[i], profit[i] + n);

	int um = n;
	while (um--)
		augment(l1, l2);

	int res = 0;
	for (int i = 0; i < n; ++i)
		res += profit[i][m1[i]];
	return res;
}

#endif
