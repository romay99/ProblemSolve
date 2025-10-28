def dfs(n, computers, start, visited):
    visited[start] = True
    for end in range(n):
        if end != start and computers[start][end] == 1:
            if visited[end] == False:
                dfs(n, computers, end, visited)

def solution(n, computers):
    visited = [False] * n
    answer = 0
    for i in range(n):
        if visited[i] == False:
            dfs(n, computers, i, visited)
            answer += 1
    return answer