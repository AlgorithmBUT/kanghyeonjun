def solution(s):
    answer = [0, 0]

    while (True):
        tmp = ""

        for i in s:
            if i == '0':
                answer[1] += 1
            else:
                tmp += i

        length = len(tmp)
        s = bin(length)[2:]
        answer[0] += 1
        if (tmp == '1'):
            break;

    return answer