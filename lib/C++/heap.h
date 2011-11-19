#ifndef HEAP__
#define HEAP__

int heap[MAX_N + 10]; 
int heapAt[MAX_N + 10]; 
int nheap; 
int d[MAX_N + 10]; 

void heapSwap(int i, int j) 
{ 
	swap(heap[i], heap[j]); 
	heapAt[heap[i]] = i; 
	heapAt[heap[j]] = j; 
} 

void heapUp(int i) 
{ 
	int j; 
	while (i > 0 && d[heap[i]] < d[heap[j = (i - 1) / 2]]) { 
		heapSwap(i, j); 
		i = j; 
	} 
} 

void heapDown(int i) 
{ 
	while (true) { 
		int j = i; 
		if (2 * i + 1 < nheap && d[heap[2 * i + 1]] < d[heap[j]]) 
			j = 2 * i + 1; 
		if (2 * i + 2 < nheap && d[heap[2 * i + 2]] < d[heap[j]]) 
			j = 2 * i + 2; 
		if (j == i) 
			break; 
		heapSwap(i, j); 
		i = j; 
	} 
} 

#endif