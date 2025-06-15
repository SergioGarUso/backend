package com.mayagenda.backend.service;

import com.mayagenda.backend.entity.Cita;
import com.mayagenda.backend.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduledReminderService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private WhatsAppService whatsappService;

    @Scheduled(cron = "0 0 8 * * *", zone = "Europe/Madrid") // todos los días a las 08:00
    public void enviarRecordatorios() {
        LocalDate hoy = LocalDate.now();
        List<Cita> citasHoy = citaRepository.findByFecha(hoy);

        for (Cita cita : citasHoy) {
            String mensaje = String.format(
                "Hola %s, te recordamos que tienes una cita hoy a las %s. Descripción: %s",
                cita.getCliente().getNombre(),
                cita.getHora().toString(),
                cita.getDescripcion()
            );

            whatsappService.enviarMensaje(cita.getCliente().getTelefono(), mensaje);
        }
    }
}
