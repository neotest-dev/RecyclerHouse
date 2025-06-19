# ♻️ RecyclerHouse - Gestión y Guía de Reciclaje

Aplicación móvil Android desarrollada en Kotlin con Firebase.  
Permite la autenticación de usuarios con Google y conexión a Firestore.  
Ideal como base para apps que gestionan usuarios, recursos o datos en tiempo real.

---

COMO EJECUTAR: Usar tu propio Firebase (sin depender del autor)

Si prefieres tener tu propio backend y no depender del autor, haz lo siguiente:

#### 🔹 Paso 1: Crea un proyecto en Firebase
- Clonar el repositorio
- Ve a [https://console.firebase.google.com](https://console.firebase.google.com)
- Crea un nuevo proyecto (ej. `RecyclerHouse`)

#### 🔹 Paso 2: Registra tu app Android

- Usa el mismo `applicationId` del proyecto (ej. `com.uct.recyclerhouse`)
- Agrega tu **SHA-1** generado desde `gradlew signingReport`
- Descarga el archivo `google-services.json` generado y colócalo en `/app/`

#### 🔹 Paso 3: Activa los servicios necesarios

- Ve a **Authentication > Sign-in method** y habilita **Google**
- Ve a **Cloud Firestore** y crea una base de datos (modo de prueba para desarrollo)

#### 🔹 Paso 4: Copia tu ID de cliente web OAuth

- Ve a Firebase Console → Authentication → Sign-in method → Google
- Copia el valor de **Web Client ID**
- Pega ese valor en `res/values/strings.xml`, reemplazando: <string name="default_web_client_id">TU_CLIENT_ID_WEB</string>

---

## 📌 Notas importantes

- El archivo `google-services.json` **no está incluido** en este repositorio por seguridad.
- Si vas a usar el Firebase del autor, debes pedirlo y enviar tu **SHA-1** para que sea agregado.
- Si vas a usar tu **propio Firebase**, asegúrate de seguir todos los pasos mencionados **anteriormente**.

---

## 🤝 Desarrolladores

Proyecto creado por:

👨‍💻 **neotest-dev**  
👨‍💻 **Luis-tb**  
👨‍💻 **diego**

🔗 Portafolio: próximamente (uno por cada integrante)

---

## 🧪 Estado del proyecto

🔧 Proyecto en desarrollo – se pueden agregar más módulos como:

- Gestión de materiales reciclables
- Recompensas por reciclaje
- Historial de usuarios

💡 ¡Contribuciones e ideas son bienvenidas!


