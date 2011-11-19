#ifndef MAXIMUM_BIPARTITE_MATCHING__
#define MAXIMUM_BIPARTITE_MATCHING__

const int MAX_N1 = 100;
const int MAX_N2 = 100;

int n1;
int n2;
bool g[MAX_N1][MAX_N2];
int m1[MAX_N1];
int m2[MAX_N2];

/* find augmenting path using dfs*/
bool visited[MAX_N2];

bool dfs(int x) 
{
	for (int y = 0; y < n2; ++y)
		if (g[x][y] && !visited[y]) {
			visited[y] = true;
			if (m2[y] == -1 || dfs(m2[y])) {
				m1[x] = y;
				m2[y] = x;
				return true;
			}
		}
	return false;
}

int match() 
{
	int res = 0;
	memset(m1, -1, sizeof(m1));
	memset(m2, -1, sizeof(m2));
	for (int i = 0; i < n1; ++i) 
		if (m1[i] == -1) {
			memset(visited, 0, sizeof(visited));
			res += dfs(i);
		}
	return res;
}

/* finding augmenting path using bfs */
int match() 
{
	int res = 0;
	memset(m1, -1, sizeof(m1));
	memset(m2, -1, sizeof(m2));
	for (int i = 0; i < n1; ++i)
		if (m1[i] == -1) {
			vi p(n1, -1);
			p[i] = -2;
			queue<int> q;
			q.push(i);
			int x;
			int y;
			while (!q.empty()) {
				x = q.front();
				q.pop();
				for (y = 0; y < n2; ++y) 
					if (g[x][y]) {
						int z = m2[y];
						if (z == -1)
							goto FOUND;
						if (p[z] == -1) {
							p[z] = x;
							q.push(z);
						}
					}
			}
			continue;
FOUND:
			++res;
			do {
				int t = m1[x];
				m1[x] = y;
				m2[y] = x;
				x = p[x];
				y = t;
			} while (x != -2);
		}
	return res;
}

#endif