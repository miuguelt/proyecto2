package backend.proyecto2;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "motos")
// Esta clase representa el modelo de datos para una moto en la base de datos
// MongoDB
public class modeloMotos {
    @Id // Esta anotación indica que el campo 'id' es la clave primaria del documento
    private String id;
    private String marca;
    private String modelo;
    private String tipo;
    private String color;
    private String año;
    private String cilindrada;
    private String peso;
    private String precio;
    private String tipo_motor;
    private String transmision;
    private String velocidad_maxima;
    private String consumo_combustible;
    private String sistema_frenos;
    private String ubicacion;
    private String descripcion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTipo_motor() {
        return tipo_motor;
    }

    public void setTipo_motor(String tipo_motor) {
        this.tipo_motor = tipo_motor;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getVelocidad_maxima() {
        return velocidad_maxima;
    }

    public void setVelocidad_maxima(String velocidad_maxima) {
        this.velocidad_maxima = velocidad_maxima;
    }

    public String getConsumo_combustible() {
        return consumo_combustible;
    }

    public void setConsumo_combustible(String consumo_combustible) {
        this.consumo_combustible = consumo_combustible;
    }

    public String getSistema_frenos() {
        return sistema_frenos;
    }

    public void setSistema_frenos(String sistema_frenos) {
        this.sistema_frenos = sistema_frenos;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
