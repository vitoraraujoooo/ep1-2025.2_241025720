package model.entidades;

import java.time.temporal.ChronoUnit;

public class PlanoDeSaude {
    private String nivelPlano;

    public PlanoDeSaude(String nivelPlano) {
        this.nivelPlano = nivelPlano;
    }

    public String getNivelPlano() {
        return nivelPlano;
    }

    public double getDescontoConsulta(Paciente paciente, Especialidade especialidade) {
        double descontoBase = 0.0;
        if (this.nivelPlano.equalsIgnoreCase("Premium")) {
            switch (especialidade) {
                case CARDIOLOGIA: descontoBase = 0.30; break;
                case PEDIATRIA: descontoBase = 0.20; break;
                case CLINICA_MEDICA: descontoBase = 0.15; break;
                default: descontoBase = 0.10; break;
            }
        } else if (this.nivelPlano.equalsIgnoreCase("Gold")) {
            switch (especialidade) {
                case CARDIOLOGIA: descontoBase = 0.50; break;
                case PEDIATRIA: descontoBase = 0.40; break;
                case CLINICA_MEDICA: descontoBase = 0.30; break;
                default: descontoBase = 0.25; break;
            }
        }

        if (paciente.getIdade() >= 60) {
            descontoBase += 0.20;
        }

        if (descontoBase > 1.0) {
            return 1.0;
        }
        return descontoBase;
    }

    public double getDescontoInternacao(Internacao internacao) {
        if (!this.nivelPlano.equalsIgnoreCase("Gold")) {
            return 0.0;
        }
        if (internacao.getDataSaida() == null) {
            return 0.0;
        }
        long diasInternado = ChronoUnit.DAYS.between(internacao.getDataEntrada(), internacao.getDataSaida());
        if (diasInternado < 7) {
            return 1.0;
        }
        return 0.0;
    }
}