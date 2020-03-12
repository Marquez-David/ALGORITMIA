def prim(matriz_distancias):
    
    num_nodos = len(matriz_distancias) #numero de nodos quu hay en el grafo
    arbol_final = []
    mas_proximo = [0]  * num_nodos #almacenara que nodo del arbol es mas proximo es mas proximo a un cierto nodo
    dist_min = [0] * num_nodos #almacena el peso del nodo mas cercano
    k = 0 #almacena el nodo
    arista = []

    for i in range(1,num_nodos):
        mas_proximo[i] = 0
        dist_min[i] = matriz_distancias[i][0]

    contador = 0
    while(contador != num_nodos-1):
        minimo = 9999
        for j in range(1,num_nodos):
            if dist_min[j] < minimo and dist_min[j] > 0:
                minimo = dist_min[j]
                k = j

        arista.append(list((mas_proximo[k]+1, k+1)))
        arbol_final.append(arista)
        dist_min[k] = -1
        for e in range(1,num_nodos):
            if matriz_distancias[e][k] < dist_min[e]:
                dist_min[e] = matriz_distancias[e][k]
                mas_proximo[e] = k
        contador +=1
    return arbol_final
        
                
        


print(prim([[9999, 2, 5, 9999], [2, 9999, 3, 1], [5, 3, 9999, 9999], [9999, 1, 9999, 9999]]))
