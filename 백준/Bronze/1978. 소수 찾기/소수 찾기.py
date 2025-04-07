n = int(input())
cnt = 0
arr = list(map(int, input().split(" ")))
newArr = []
for i in range(n):
    for j in range(1, int(arr[i])+1):
        if arr[i] % j == 0:
            cnt += 1
    if cnt == 2:
        newArr.append(arr[i])
    cnt = 0

print(len(newArr))
