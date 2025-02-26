package com.banco.cliente_service.service;

import com.banco.cliente_service.dto.CuentaDTO;
import com.banco.cliente_service.dto.MovimientosDTO;
import com.banco.cliente_service.dto.ReporteEstadoCuentaDTO;
import com.banco.cliente_service.entity.Cliente;
import com.banco.cliente_service.entity.Cuenta;
import com.banco.cliente_service.entity.Movimientos;
import com.banco.cliente_service.repository.ClienteRepository;
import com.banco.cliente_service.repository.CuentaRepository;
import com.banco.cliente_service.repository.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Override
    public ReporteEstadoCuentaDTO generarEstadoDeCuenta(Long clienteId, Date fechaInicio, Date fechaFin) {
        // Obtener el cliente
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Obtener las cuentas del cliente
        List<Cuenta> cuentas = cuentaRepository.findByClienteClienteId(clienteId);

        // Construir el DTO del reporte
        ReporteEstadoCuentaDTO reporte = new ReporteEstadoCuentaDTO();
        reporte.setClienteId(clienteId);
        reporte.setNombreCliente(cliente.getNombre());

        // Mapear las cuentas y sus movimientos
        List<CuentaDTO> cuentasDTO = cuentas.stream().map(cuenta -> {
            CuentaDTO cuentaDTO = new CuentaDTO();
            cuentaDTO.setCuentaId(cuenta.getCuentaId());
            cuentaDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
            cuentaDTO.setTipoCuenta(cuenta.getTipoCuenta());
            cuentaDTO.setSaldoInicial(cuenta.getSaldoInicial());
            cuentaDTO.setEstado(cuenta.isEstado());

            // Obtener movimientos de la cuenta en el rango de fechas
            List<Movimientos> movimientos = movimientosRepository.findByCuentaCuentaIdAndFechaBetween(
                    cuenta.getCuentaId(), fechaInicio, fechaFin);

            List<MovimientosDTO> movimientosDTO = movimientos.stream().map(movimiento -> {
                MovimientosDTO movimientoDTO = new MovimientosDTO();
                movimientoDTO.setMovimientoId(movimiento.getMovimientoId());
                movimientoDTO.setFecha(movimiento.getFecha());
                movimientoDTO.setTipoMovimiento(movimiento.getTipoMovimiento());
                movimientoDTO.setValor(movimiento.getValor());
                movimientoDTO.setSaldo(movimiento.getSaldo());
                return movimientoDTO;
            }).collect(Collectors.toList());

            cuentaDTO.setMovimientos(movimientosDTO);
            return cuentaDTO;
        }).collect(Collectors.toList());

        reporte.setCuentas(cuentasDTO);
        return reporte;
    }
}