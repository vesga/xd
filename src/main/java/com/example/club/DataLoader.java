package com.example.club;

import com.example.club.entity.*;
import com.example.club.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClubRepository clubRepository;
    private final JugadorRepository jugadorRepository;
    private final AsociacionRepository asociacionRepository;
    private final CompeticionRepository competicionRepository;

    public DataLoader(ClubRepository clubRepository,
                      JugadorRepository jugadorRepository,
                      AsociacionRepository asociacionRepository,
                      CompeticionRepository competicionRepository) {
        this.clubRepository = clubRepository;
        this.jugadorRepository = jugadorRepository;
        this.asociacionRepository = asociacionRepository;
        this.competicionRepository = competicionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Asociacion fcf = new Asociacion();
        fcf.setNombre("Federación Colombiana de Fútbol");
        fcf.setPais("Colombia");
        fcf.setPresidente("Ramón Jesurún");
        asociacionRepository.save(fcf);

        Competicion liga = new Competicion();
        liga.setNombre("Liga BetPlay");
        liga.setMontoPremio(5000000);
        liga.setFechaInicio(LocalDate.of(2025, 1, 15));
        liga.setFechaFin(LocalDate.of(2025, 6, 30));

        Competicion copa = new Competicion();
        copa.setNombre("Copa Colombia");
        copa.setMontoPremio(3000000);
        copa.setFechaInicio(LocalDate.of(2025, 2, 10));
        copa.setFechaFin(LocalDate.of(2025, 7, 15));

        competicionRepository.saveAll(Arrays.asList(liga, copa));

        Entrenador entrenador1 = new Entrenador();
        entrenador1.setNombre("Alberto");
        entrenador1.setApellido("Gamero");
        entrenador1.setEdad(58);
        entrenador1.setNacionalidad("Colombiana");

        Club millonarios = new Club();
        millonarios.setNombre("Millonarios FC");
        millonarios.setAsociacion(fcf);
        millonarios.setEntrenador(entrenador1); // will be saved via cascade
        millonarios.setCompeticiones(Arrays.asList(liga, copa));

        clubRepository.save(millonarios);

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Andrés");
        jugador1.setApellido("Llinás");
        jugador1.setNumero(4);
        jugador1.setPosicion("Defensa");
        jugador1.setClub(millonarios);

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Daniel");
        jugador2.setApellido("Ruiz");
        jugador2.setNumero(10);
        jugador2.setPosicion("Mediocampista");
        jugador2.setClub(millonarios);

        jugadorRepository.saveAll(List.of(jugador1, jugador2));

        millonarios.setJugadores(List.of(jugador1, jugador2));
        clubRepository.save(millonarios);

        System.out.println("✅ Datos de ejemplo cargados correctamente");
    }
}
