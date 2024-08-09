package app;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class App {

    private void m1(){
        LocalDate fecha = LocalDate.now();
        LocalTime hora = LocalTime.now();
        LocalDateTime fechaHora = LocalDateTime.now();
        ZonedDateTime fechaHoraZona = ZonedDateTime.now();
        OffsetDateTime fechaHoraOffset = OffsetDateTime.now();
        OffsetTime horaOffset = OffsetTime.now();
        Instant instante = Instant.now();
        Period period = Period.ofYears(1);
        Duration duration = Duration.ofHours(5);
        Year año = Year.now();
        YearMonth añoMes = YearMonth.now();
        MonthDay mesDia = MonthDay.now();
        DayOfWeek dia = LocalDate.now().getDayOfWeek();
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.of(2024, 12, 31));
        int diaDelMes = LocalDate.now().get(ChronoField.DAY_OF_MONTH);

        System.out.println(diaDelMes);
    }

    //Convertir de String a LocalDate/Time
    private void m2(){
        String fecha = "2024-08-09";
        String hora = "15:30";

        LocalDate localDate = LocalDate.parse(fecha);
        LocalTime localTime = LocalTime.parse(hora);

        System.out.println("Fecha: " + localDate);
        System.out.println("Hora: " + localTime);
    }

    //Fechas con formato
    private void m3(){
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("Formato 1: " + fechaHoraActual.format(formato1));
        System.out.println("Formato 2: " + fechaHoraActual.format(formato2));
    }

    //Duración de un evento
    private void m4(){
        Instant inicio = Instant.now();

        //Bloque de código pesado
        for (int i = 0; i < 1000000; i++){
            Math.random();
        }

        Instant fin = Instant.now();
        Duration duracion = Duration.between(inicio, fin);

        System.out.println("Duración: " + duracion.toMillis() + " milisegundos");
    }

    //Calcular la edad de una persona
    private void m5(){
        LocalDate fechaNacimiento = LocalDate.of(1990, 8, 8);
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, fechaActual);

        System.out.println("Edad: " + periodo.getYears() + " años, " + periodo.getMonths() + " mes, " + periodo.getDays() + " dias");
    }

    //Calcular cuantas horas ha trabajado una persona
    private void m6(){
        LocalTime horaEntrada = LocalTime.of(9, 30);
        LocalTime horaSaida = LocalTime.of(18, 30);

        Duration tiempoTrabajado = Duration.between(horaEntrada, horaSaida);
        Duration jornadaLaboral = Duration.ofHours(8);

        if(tiempoTrabajado.compareTo(jornadaLaboral) < 0){
            System.out.println("El empleado no cumplió las 8 horas requeridas");
        }else{
            Duration horasExtra = tiempoTrabajado.minus(jornadaLaboral);
            System.out.println("Horas trabajadas: " + tiempoTrabajado.toHours() + " horas");
            System.out.println("Horas extra: " + horasExtra.toHours() + " horas");
        }
    }

    //calcular diferencia entre dos fechas
    private void m7(){
        LocalDate fechaInicio = LocalDate.of(2022, 1, 1);
        LocalDate fechaFinal = LocalDate.of(2024, 8, 9);

        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFinal);
        long semanas = ChronoUnit.WEEKS.between(fechaInicio, fechaFinal);
        long meses = ChronoUnit.MONTHS.between(fechaInicio, fechaFinal);
        long años = ChronoUnit.YEARS.between(fechaInicio, fechaFinal);

        System.out.println("Dias: " + dias);
        System.out.println("Semanas: " + semanas);
        System.out.println("Meses: " + meses);
        System.out.println("Años: " + años);
    }

    //Aumentar 1 año de periodo
    private void m8(){
        LocalDate hoy = LocalDate.now();
        LocalDate proximaAño = hoy.plus(Period.ofYears(1));

        System.out.println("Fecha de hoy: " + hoy);
        System.out.println("Mismo día en el próximo año: " + proximaAño);
    }

    /** PLANIFICACIÓN DE CONFERENCIA
     * Imagina que estás desarrollando un sistema para planificar una conferencia internacional que se llevará a cabo en diferentes zonas horarias.
     *
     * El sistema debe:
     *
     1 Establecer la fecha y hora de inicio de la conferencia en la zona horaria de Nueva York (EST).
     2 Convertir la hora de inicio a otras zonas horarias importantes: Londres (GMT), Tokio (JST), y Sídney (AEST).
     3 Calcular la duración de la conferencia, que es de 8 horas, y mostrar la hora de finalización en todas las zonas horarias mencionadas.
     4 Calcular cuántos días, horas y minutos faltan desde la hora actual (en UTC) hasta el inicio de la conferencia en Nueva York.
     5 Mostrar la duración de la conferencia en formato de horas y minutos.
     */

    private void m9(){
        //1.  Establecer la fecha y hora de inicio de la conferencia en Nueva York
        ZonedDateTime inicioConferenciaNY = ZonedDateTime.of(2024, 12, 1, 9, 0, 0, 0, ZoneId.of("America/New_York"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

        System.out.println("Fecha y hora de inicio en Nueva York: " + inicioConferenciaNY.format(formatter) + " \n");

        // 2. Convertir la hora de inicio a otras zonas horarias importantes
        ZonedDateTime inicioConferenciaLondres = inicioConferenciaNY.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime inicioConferenciaTokio = inicioConferenciaNY.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime inicioConferenciaSydney = inicioConferenciaNY.withZoneSameInstant(ZoneId.of("Australia/Sydney"));

        System.out.println("Fecha y hora de inicio en Londres: " + inicioConferenciaLondres.format(formatter));
        System.out.println("Fecha y hora de inicio en Tokio: " + inicioConferenciaTokio.format(formatter));
        System.out.println("Fecha y hora de inicio en Sydney: " + inicioConferenciaSydney.format(formatter) + " \n");

        //ZoneId.getAvailableZoneIds().forEach(System.out::println);

        //3. Calcular la duración de la conferencia y mostrar la hora de finalización
        Duration duracionConferencia = Duration.ofHours(8);

        ZonedDateTime finConferenciaNY = inicioConferenciaNY.plus(duracionConferencia);
        ZonedDateTime finConferenciaLondres = inicioConferenciaLondres.plus(duracionConferencia);
        ZonedDateTime finConferenciaTokio = inicioConferenciaTokio.plus(duracionConferencia);
        ZonedDateTime finConferenciaSydney = inicioConferenciaSydney.plus(duracionConferencia);

        System.out.println("Fecha y hora de fin en Nueva York: " + finConferenciaNY.format(formatter) );
        System.out.println("Fecha y hora de fin en Londres: " + finConferenciaLondres.format(formatter));
        System.out.println("Fecha y hora de fin en Tokio: " + finConferenciaTokio.format(formatter));
        System.out.println("Fecha y hora de fin en Sydney: " + finConferenciaSydney.format(formatter));

        // 4. Calcular el tiempo que falta desde ahora (UTC) hasta el inicio de la conferencia en Nueva York
        ZonedDateTime ahoraUTC = ZonedDateTime.now(ZoneId.of("UTC"));
        long diasFaltantes = ChronoUnit.DAYS.between(ahoraUTC, inicioConferenciaNY);
        long horasFaltantes = ChronoUnit.HOURS.between(ahoraUTC, inicioConferenciaNY) % 24;
        long minutosFaltantes = ChronoUnit.MINUTES.between(ahoraUTC, inicioConferenciaNY) % 60;

        System.out.println(diasFaltantes + " días" );
        System.out.println(horasFaltantes + " horas" );
        System.out.println(minutosFaltantes + " minutos" );

        // 5. Mostrar la duración de la conferencia en formato de horas y minutos
        long horasDuracion = duracionConferencia.toHours();
        long minutosDuracion = duracionConferencia.toMinutes() % 60;

        System.out.println("Duracion de la conferencia es : " + horasDuracion + " horas " + minutosDuracion + " minutos");

    }

    public static void main(String[] args) {
        App app = new App();
        app.m9();
    }
}
