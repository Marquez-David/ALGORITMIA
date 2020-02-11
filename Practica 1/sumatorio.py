def sumatorio(num):
    if(num >1):
        return num + sumatorio(num-1)
    else:
        return 1
    
print(sumatorio(5))