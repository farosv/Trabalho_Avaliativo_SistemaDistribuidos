package com.example.VeiculoController;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeiculoController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VeiculoController(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) dataSource);
    }

    @PostMapping("/veiculos")
    public void incluirClassificado(@RequestBody Veiculo veiculo) {
        adicionarVeiculoNoBanco(veiculo);
    }

    private void adicionarVeiculoNoBanco(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (nome_cliente, marca_modelo, ano_modelo, valor_venda, data_publicacao) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, veiculo.getNomeCliente(), veiculo.getMarcaModeloVeiculo(), veiculo.getAnoModelo(), veiculo.getValorVenda(), veiculo.getDataPublicacao());
    }
}
