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
        @ManyToOne
        @JoinColumn(name = "rol_id", nullable = false)
        private Rol rol;

        public Usuario() {
        }

        public Usuario(int id, String nombre, String apellido, String correo,
                       String contrasena, int codigo, String nombreUsuario,
                       boolean activo, Rol rol) {
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

        public Rol getRol() {
            return rol;
        }

        public void setRol(Rol rol) {
            this.rol = rol;
        }
    }
