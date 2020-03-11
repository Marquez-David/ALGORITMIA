def soldarEcaleras(escaleras_ordenado):
    """
    list -> list
    OBJ: Calcular el timpo ttoal en unir las escaleras
    PRE: lista de ints
    """
    tiempo_total = escaleras_ordenado[0] + escaleras_ordenado[1]
    tiempo_parcial = tiempo_total
    for i in range(2, len(escaleras_ordenado)):
        tiempo_total += tiempo_parcial + escaleras_ordenado[i]
        tiempo_parcial += escaleras_ordenado[i]

    return tiempo_total


def ordenarEscaleras(escaleras):
    """
    list -> list
    OBJ: Ordenar las escaleras de menor a mayor
    PRE: null
    """
    return sorted(escaleras)

print(soldarEcaleras(ordenarEscaleras([12, 8, 23, 6])))



