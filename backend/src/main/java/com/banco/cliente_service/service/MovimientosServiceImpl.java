package com.banco.cliente_service.service;

import com.banco.cliente_service.dto.MovimientosDTO;
import com.banco.cliente_service.entity.Cuenta;
import com.banco.cliente_service.entity.Movimientos;
import com.banco.cliente_service.repository.CuentaRepository;
import com.banco.cliente_service.repository.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovimientosServiceImpl implements MovimientosService {

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    @Transactional
    public MovimientosDTO registrarMovimiento(MovimientosDTO movimientosDTO) {
        // Obtener la cuenta asociada al movimiento
        Cuenta cuenta = cuentaRepository.findById(movimientosDTO.getCuentaId())
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        // Validar saldo para retiros
        if (movimientosDTO.getValor() < 0 && cuenta.getSaldoInicial() + movimientosDTO.getValor() < 0) {
            throw new RuntimeException("Saldo no disponible");
        }

        // Actualizar saldo de la cuenta
        cuenta.setSaldoInicial(cuenta.getSaldoInicial() + movimientosDTO.getValor());
        cuentaRepository.save(cuenta);

        // Crear y guardar el movimiento
        Movimientos movimiento = new Movimientos();
        movimiento.setFecha(new Date());
        movimiento.setTipoMovimiento(movimientosDTO.getValor() >= 0 ? "Depósito" : "Retiro");
        movimiento.setValor(movimientosDTO.getValor());
        movimiento.setSaldo(cuenta.getSaldoInicial());
        movimiento.setCuenta(cuenta);

        Movimientos movimientoGuardado = movimientosRepository.save(movimiento);

        // Convertir a DTO y retornar
        return convertirADTO(movimientoGuardado);
    }

    private MovimientosDTO convertirADTO(Movimientos movimiento) {
        MovimientosDTO movimientosDTO = new MovimientosDTO();
        movimientosDTO.setMovimientoId(movimiento.getMovimientoId());
        movimientosDTO.setFecha(movimiento.getFecha());
        movimientosDTO.setTipoMovimiento(movimiento.getTipoMovimiento());
        movimientosDTO.setValor(movimiento.getValor());
        movimientosDTO.setSaldo(movimiento.getSaldo());
        movimientosDTO.setCuentaId(movimiento.getCuenta().getCuentaId());
        return movimientosDTO;
    }
}