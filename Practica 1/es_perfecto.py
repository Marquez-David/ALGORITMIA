def es_perfecto(num):
    """ int -> bool
    OBJ: Sin un numero es perfecto
    PRE:num > 0"""
    
    perfecto = False
    sumador = 0
    for i in range(1,num):
        if(num%i == 0):
            sumador = sumador + i
    if(sumador == num):
        perfecto = True
    return perfecto


#Probador
#print(es_perfecto(8128))
