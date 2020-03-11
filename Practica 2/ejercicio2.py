def ordenarFicheros(lista_factores):
    """
    list -> list
    OBJ: Ordenar una lista de menor a mayor
    PRE: lista de floats
    """
    return sorted(lista_factores)

def calcularPromedio(longitudes, peticiones):
    """
    list, list -> list
    OBJ: Determinar le factor de cada uno de los ficheros
    PRE: len(longitudes) = len(peticiones)
    """

    lista_factores = [] #Creamos una lista que contendra los factores de cada fichero
    
    for i in range(len(longitudes)):
        factor = longitudes[i]/peticiones[i]
        lista_factores.append(factor)
        
    return lista_factores
        
#print(calcularPromedio([2, 1, 5],[2, 6, 1]))
print(ordenarFicheros(calcularPromedio([2, 1, 5],[2, 6, 1])))
