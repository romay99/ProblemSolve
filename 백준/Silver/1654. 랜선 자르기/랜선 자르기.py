k, n = map(int, (input().split(" ")))
arr = []

for i in range(k):
    arr.append(int(input()))

left = 0
right = max(arr)
res = 0


def BS(left, right):
    if left > right:
        return
    global n
    global res
    mid = (left+right)//2
    count = 0
    for i in arr:
        count += i // mid
    if count >= n:
        res = mid
        BS(mid + 1, right)
    else:
        BS(left, mid - 1)


BS(0, right*2)
print(res)