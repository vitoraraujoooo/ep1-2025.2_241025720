public class plano_de_saude{
    private String nivel_plano;
}

public void plano_de_saude(string nivel_plano){
    this.nivel_plano = nivel_plano;
}

public void descontos(){
    if (nivel_plano == "premium"){
        //descontos de cada especialidade
        //50% de desconto na internação
    }else if(nivel_plano == "diamante"){
        //descontos para cada especialidade;
        //internação gratuita
    }else if(nivel_plano == "senior"){
        //plano senior contem maiores porcentagens de desconto para todas as especialidades
        //internação gratuita
    }
}


