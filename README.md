Hospital Appointment System - Backend / Hastane Randevu Sistemi - Backend

Bu proje, hastane randevu yönetimi için geliştirilmiş bir Spring Boot backend uygulamasıdır. Kullanıcılar randevu alabilir, iptal edebilir, adminler randevuları onaylayabilir veya reddedebilir. JWT ile güvenlik sağlanmaktadır.

This project is a Spring Boot backend application for hospital appointment management. Users can book or cancel appointments, and admins can approve or reject them. Security is provided with JWT.

🔹 Özellikler / Features

Kullanıcılar / Users:

Kayıt olma ve giriş yapma / Register and login

Randevu alma ve iptal etme (sadece kendi randevuları) / Book and cancel appointments (only own appointments)

Randevu iptali için son tarih kontrolü (randevudan 1 gün öncesine kadar) / Cancellation allowed until 1 day before appointment

Admin:

Randevuları onaylama veya reddetme / Approve or reject appointments

Yeni poliklinik veya doktor ekleme / Add new clinics or doctors

Güvenlik / Security:

JWT ile kullanıcı doğrulama / JWT-based authentication

Role tabanlı erişim kontrolü (ADMIN, USER) / Role-based access control

Database: PostgreSQL

Randevu, kullanıcı, poliklinik ve doktor tabloları / Appointment, user, clinic, and doctor tables

Enum tabanlı randevu durumu (ONAYLANDI, BEKLEMEDE, REDDEDİLDİ) / Enum-based appointment status

🔹 Teknolojiler / Technologies

Java 17

Spring Boot 3

Spring Security & JWT

Spring Data JPA

PostgreSQL

Maven

🔹 Kurulum / Setup

Repository’yi klonlayın / Clone the repository:

git clone https://github.com/cakmaak/HospitalAppointmentSystem-Backend.git
cd HospitalAppointmentSystem-Backend


PostgreSQL bağlantı ayarlarını application.properties dosyasında yapılandırın / Configure PostgreSQL connection in application.properties:

spring.datasource.url=jdbc:postgresql://[HOST]:5432/[DB_NAME]
spring.datasource.username=[USERNAME]
spring.datasource.password=[PASSWORD]
spring.jpa.hibernate.ddl-auto=update


Projeyi Maven ile çalıştırın / Run the project with Maven:

mvn spring-boot:run


Uygulama varsayılan olarak http://localhost:8080 adresinde çalışacaktır / The app will run at http://localhost:8080 by default.

🔹 API Endpoints
Auth

POST /auth/register - Yeni kullanıcı kaydı / Register new user

POST /auth/login - Giriş ve JWT token alma / Login and get JWT token

Appointment

GET /appointment/user - Kullanıcının randevularını listele / List user’s appointments

POST /appointment - Randevu oluştur / Create appointment

PUT /appointment/cancelappointment - Randevu iptali (1 gün öncesine kadar) / Cancel appointment (until 1 day before)

PUT /appointment/acceptappointment/{id} - Admin onayı / Admin approval

Admin

POST /admin/savepoliklinik - Yeni poliklinik ekleme / Add new clinic

POST /admin/savedoctor - Yeni doktor ekleme / Add new doctor

🔹 Kullanım / Usage

Kullanıcı giriş yaptıktan sonra JWT token alır / User receives JWT token after login.

Admin yetkisi olan kullanıcılar sadece @PreAuthorize("hasAuthority('ADMIN')") ile işaretli endpointlere erişebilir / Only users with ADMIN authority can access endpoints annotated with @PreAuthorize("hasAuthority('ADMIN')").

Kullanıcı kendi randevularını iptal edebilir. Randevu tarihinden 1 gün öncesinden sonra iptal edilemez / Users can cancel only their own appointments. Cancellation not allowed after 1 day before appointment.

🔹 License

Bu proje MIT lisansı ile lisanslanmıştır / This project is licensed under MIT License.
