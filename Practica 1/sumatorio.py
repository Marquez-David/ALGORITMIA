def sumatorio(num):
    """
    int -> int
    OBJ: Sunatorio de 1 a num
    PRE: num debe ser entero > 1
    """
    if(num >1):
        return num + sumatorio(num-1)
    else:
        return 1
    
print(sumatorio(5))


