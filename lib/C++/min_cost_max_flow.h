#ifndef MIN_COST_FLOW__
#define MIN_COST_FLOW__

/*
min-cost-max-flow fragment of petr's code for topcoder SRM 407 Div 1 1000 TransformMatrix  
*/
const int N = 802;
const int INF_D = 1000000;

int g[N][N];
int cost[N][N];

pair<int, int> minCostMaxflow(int n, int s, int t) {
	int flow = 0;
	int flowCost = 0;
	vi mu(n);
	while (true) {
		vi d(n, INF_D);
		d[s] = 0;
		vector<bool> fix(n, false);
		vi prev(n);
		int last = 0;
		while (true) {
			int bi = -1;
			int best = INF_D;
			for (int i = 0; i < n; ++i)
				if (!fix[i] && d[i] < best) {
					best = d[i];
					bi = i;
				}
			if (bi < 0)
				break;
			last = best;
			fix[bi] = true;
			for (int i = 0; i < n; ++i)
				if (g[bi][i] > 0) {
					int nd = d[bi] + cost[bi][i] + mu[bi] - mu[i];
					if (nd < d[i]) {
						d[i] = nd;
						prev[i] = bi;
					}
				}
		}
		if (!fix[t])
			break;
		++flow;
		flowCost += d[t] - mu[s] + mu[t];
		for (int i = t; i != s; i = prev[i]) {
			--g[prev[i]][i];
			++g[i][prev[i]];
		}
		for (int i = 0; i < n; ++i)
			if (d[i] < INF_D)
				mu[i] += d[i];
			else
				mu[i] += last;
	}
	return make_pair(flow, flowCost);
}

#endif