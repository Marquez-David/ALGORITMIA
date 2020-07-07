def numBilletes(billetes, cambio):
    """ list, int -> int
    PRE: valorBilleantes.length == cantidadBilletes.length
    OBJ: devolver un cambio monetario usando el menor numero de billetes """

    billetesDisponibles = []
    matrizFinal = []

    for billete in billetes:
        billetesDisponibles.append(billete)
        for i in range(cambio+1):
            matrizFinal.append(calcularCambio(billetesDisponibles, i))

    return matrizFinal

def calcularCambio(billetes, cambio):
    numBilletes = 0
    if (cambio == 0):
        numBilletes = 0
    elif (len(billetes) == 1):
        numBilletes = 1

    return numBilletes
        
    
print(numBilletes([1, 2, 2, 2, 3, 3, 4], 7))

