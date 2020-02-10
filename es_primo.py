
def es_primo(num):
    """ int -> bool
    OBJ: Si un numero es primo
    PRE: num > 0 """

    primo = False
    cont = 0
    for i in range(1, num):
        if(num % i == 0):
            cont = cont + 1
    if(cont<=2):
        primo = True
    return primo

print(es_primo(7))
