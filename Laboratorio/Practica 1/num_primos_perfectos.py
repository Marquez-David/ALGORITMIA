def num_prim_perf(num):
    """ int -> int, int
    OBJ: num de primos y perfectos < num
    PRE: num > 0 """

    from es_primo import es_primo
    from es_perfecto import es_perfecto

    num_primos = 0
    num_perf = 0

    for i in range(1,num):
        if(es_primo(i)):
            num_primos = num_primos + 1
        elif(es_perfecto(i)):
            num_perf = num_perf + 1
    return num_primos, num_perf
            
            

print(num_prim_perf(8))



