def tapar(lista_tapones, lista_botellas):
    """
    list, list -> null
    OBJ: determinar que tapon va con cada botella y viceversa
    PRE: len(lista_tapones) == len(lista_botellas)
    """

    from random import randrange

    parejas = []
    tapones_menor = []
    tapones_mayor = []
    botellas_menor = []
    botellas_mayor = []
    
    pivote_tapones = 0
    pivote_botellas = 0
    
    if len(lista_tapones) == 1:
        parejas.append(("Tapon: ", lista_tapones[0], "Botella: ", lista_botellas[0]))
        
    elif len(lista_tapones) == 0 and len(lista_botellas) == 0:
        print("No hay tapones ni botellas")

    else:
        print("Buscamos el pivote de los tapones")
        
        pivote_tapones = lista_tapones[randrange(len(lista_tapones))] #seleccionamos un pivote de tapones
        print("Pivote de tapones: ", pivote_tapones)

        print("Buscamos el piovte para las botellas")
        
        pivote_botellas = buscarPivote(lista_botellas, pivote_tapones) #buscamos el mismo pivote en las botellas
        parejas.append(("Tapon: ", pivote_tapones, "Botella: ", pivote_botellas))
        print("Pivote de botellas: ", pivote_botellas)
        
        for i  in range(len(lista_tapones)):
            if lista_tapones[i] < pivote_botellas:
                tapones_menor.append(lista_tapones[i])
                
            elif lista_tapones[i] > pivote_botellas:
                tapones_mayor.append(lista_tapones[i])
                
            if lista_botellas[i] < pivote_tapones:
                botellas_menor.append(lista_botellas[i])
                
            elif lista_botellas[i] > pivote_tapones:
                botellas_mayor.append(lista_botellas[i])
                
        print("TAPONES")
        print(tapones_menor)
        print(tapones_mayor)

        print("BOTELLAS")
        print(botellas_menor)
        print(botellas_mayor)

        tapar(tapones_menor, botellas_menor)
        tapar(tapones_mayor, botellas_mayor)
   
def buscarPivote(lista, elem):
    """
    list, int -> int
    OBJ: devolver un determinado elemento de una lista
    PRE: elem in lista
    """
    for i in lista:
        if elem == i:
            return i

tapar([4, 9, 6, 3], [6, 4, 3, 9])
