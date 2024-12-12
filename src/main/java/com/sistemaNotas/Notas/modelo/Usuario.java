    package com.sistemaNotas.Notas.modelo;

    import jakarta.persistence.*;


    @Entity
    public class Usuario{

        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private int id;
        private String nombre;
        private String apellido;
        private String correo;
        private String contrasena;

        private int codigo;
        private String nombreUsuario;

        private boolean activo;

        private Integer rol;

        public Usuario() {
        }

        public Usuario(int id, String nombre, String apellido, String correo,
                       String contrasena, int codigo, String nombreUsuario,
                       boolean activo, Integer rol) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.correo = correo;
            this.contrasena = contrasena;
            this.codigo = codigo;
            this.nombreUsuario = nombreUsuario;
            this.activo = activo;
            this.rol = rol;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        public boolean isActivo() {
            return activo;
        }

        public void setActivo(boolean activo) {
            this.activo = activo;
        }

        public Integer getRol() {
            return rol;
        }

        public void setRol(Integer rol) {
            this.rol = rol;
        }
    }
