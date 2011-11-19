#ifndef MAX_FLOW__
#define MAX_FLOW__

/*
Ford-Fulkerson method, i.e. find augment path
*/

/*
dfs to find augment path, O(|f*|E)
*/
const int INF = 1000000000;
const int MAX_N = 100;

int n;
int g[MAX_N][MAX_N];
bool visited[MAX_N];

int dfs(int x, int t, int by) 
{
	if (x == t)
		return by;
	if (visited[x])
		return 0;
	visited[x] = true;
	int a;
	for (int y = 0; y < n; ++y)
		if (g[x][y] > 0 && (a = dfs(y, t, min(by, g[x][y]))) > 0) {
			g[x][y] -= a;
			g[y][x] += a;
			return a;
		}
	return 0;
}

int flow(int s, int t) 
{
	int res = 0;
	while (true) {
		memset(visited, 0, sizeof(visited));
		int a = dfs(s, t, INF);
		if (a > 0)
			res += a;
		else
			break;
	}
	return res;
}

/*
Edmond-Karp algorithm, i.e. bfs to find augment path, O(VE^2)
*/
const int MAX_N = 100;

int n;
int g[MAX_N][MAX_N];

int flow(int s, int t) 
{
	int res = 0;
	while (true) {
		vi p(n, -1);
		p[s] = -2;
		queue<int> q;
		q.push(s);
		while (!q.empty()) {
			int x = q.front();
			q.pop();
			if (x == t)
				goto FOUND;
			for (int y = 0; y < n; ++y)
				if (g[x][y] > 0 && p[y] == -1) {
					p[y] = x;
					q.push(y);
				}
		}
		break;
FOUND:
		int a = INF;
		for (int x = t; p[x] != -2; x = p[x])
			a = min(a, g[p[x]][x]);
		for (int x = t; p[x] != -2; x = p[x]) {
			g[p[x]][x] -= a;
			g[x][p[x]] += a;
		}
		res += a;
	}
	return res;
}

/*
push-relabel method, O(V^2E)
*/

/*
FIFO implementation, O(V^3)
*/
const int MAX_N = 100;

struct Edge {
	int to;
	int cap;
	int rev;

	Edge(int _to, int _cap) : to(_to), cap(_cap) {

	}
};

int n;
vector<Edge> adj[MAX_N];

int flow(int s, int t) 
{
	vi e(n);
	vi h(n);
	vector<bool> visited(n);
	h[s] = n;
	visited[s] = true;
	visited[t] = true;
	queue<int> q;
	for (int i = 0; i < SZ(adj[s]); ++i) {
		Edge &curEdge = adj[s][i];
		Edge &revEdge = adj[curEdge.to][curEdge.rev];
		int y = curEdge.to;
		int f = curEdge.cap;
		assert(f > 0);
		curEdge.cap -= f;
		revEdge.cap += f;
		e[s] -= f;
		e[y] += f;
		if (y != t) {
			visited[y] = true;
			q.push(y);
		}
	}

	while (!q.empty()) {
		int x = q.front();
		q.pop();
		visited[x] = false;
		assert(e[x] > 0);
		while (true) {
			int lowest = -1;
			for (int i = 0; i < SZ(adj[x]); ++i) if (adj[x][i].cap > 0) {
				Edge &curEdge = adj[x][i];
				Edge &revEdge = adj[curEdge.to][curEdge.rev];
				int y = curEdge.to;
				if (h[x] > h[y]) {// push
					int f = min(curEdge.cap, e[x]);
					curEdge.cap -= f;
					revEdge.cap += f;
					e[x] -= f;
					e[y] += f;
					if (!visited[y]) {
						visited[y] = true;
						q.push(y);
					}
					if (e[x] == 0)
						goto NEXT;
				} else {
					if (lowest == -1 || h[y] < lowest)
						lowest = h[y];
				}
			}
			// relabel
			h[x] = lowest + 1;
		}
NEXT:;
	}
	return e[t];
}

#endif