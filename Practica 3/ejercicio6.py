def calcularDistancia(distancia_altura, lim_inf, lim_sup):
    """
    list, int, int -> list
    OBJ: determinar la distancia optima
    PRE: lim_sup = len(distancia_altura)-1 y lim_inf = 0
    """

    mitad = int(lim_inf + (lim_sup - lim_inf)/2)

    if lim_inf == lim_sup:
        return distancia_altura[lim_inf]
    
    elif distancia_altura[mitad][1] >= distancia_altura[mitad+1][1]:
        return calcularDistancia(distancia_altura, lim_inf, mitad)

    else:
        return calcularDistancia(distancia_altura, mitad+1, lim_sup)

print(calcularDistancia([[1, 5], [5, 10], [15, 200]], 0, 2))


