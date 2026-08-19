def solution(n):
    answer = 0

    for start in range(1,n+1):
        tmp = 0
        for i in range(start,n+1):
            tmp+=i
            if (tmp==n):
                answer+=1
                break

    return answer