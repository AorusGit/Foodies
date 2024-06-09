# Foodies
Foodies adalah Aplikasi Sederhana yang menyediakan informasi mengenai deskripsi kuliner Nusantara, dari resep hingga kisaran harga untuk menemani perjalanan jelajah rasa Nusantara bagi para Wisatawan.

## Group Name : SERENITY
Nama Anggota:
1.	H071231044 – Mohammad Abdul Razaq 
2.	H071231054 – Kevin Ryadi Rante Pamumbu 
3.	H071231026 – Zainab Muchsinin 

## Tema yang Dipilih : Travel and Culture

## Nama Pendamping : Muhammad Thoriq Ali Said

## Tim Juri :
1. Muhammad Rizki
2. Muh. Resky Fadil

## Executive Summary : 
Indonesia memiliki keanekaragaman budaya dan kultur yang dimiliki oleh berbagai daerah di dalamnya, termasuk dalam hal makanan dan minuman. Dikarenakan hal tersebut, banyak wisatawan dari berbagai macam negeri datang ke Indonesia untuk merasakan keanekaragaman budaya dan kuliner di Indonesia.

Foodies merupakan aplikasi yang di buat untuk membantu user, terutama para wisatawan untuk mengetahui berbagai jenis kuliner yang ada di Indonesia. Aplikasi ini menginformasikan tentang data dari suatu kuliner, yang di mana dapat di ketahui asal kuliner tersebut dan demikian pula resepnya. Selain itu, aplikasi ini dapat menunjukkan tarif dari suatu kuliner yang di tujukan untuk para wisatawan yang hendak mencoba kuliner di tempat mereka berwisata.

Tujuan dibuatnya aplikasi adalah untuk mempermudah user dalam mencari kuliner yang ingin dibuat dan diketahui oleh para wisatawan apabila ingin mencari kuliner yang terkenal di tempat wisata tersebut. Aplikasi ini tidak hanya ditujukan untuk para wisatawan saja, akan tetapi juga untuk warga lokal yang hendak membuat kuliner serupa, sehingga dengannya dapat membantu untuk menemukan resep dan informasi mengenai kuliner yang terkenal di tempat wisata tersebut.

## Fitur Aplikasi
1. Admin
   - Sign In
   - Add Menu
   - Update Menu
   - Delete Menu
2. User
   Menampilkan data provinsi yang didalamnya terdapat list makanan dan minuman tradisional yang berisi deskripsi dari makanan dan minuman tradisional tersebut.

## Penjelasan Penerapan Prinsip OOP
1. Inheritance : class Foods mewariskan atribut nama kepada class Provinsi, sehingga atribut nama pada class Provinsi tinggal menggunakan keyword 'super' untuk menggunakan atribut 'nama'.
2. Polymorphism : ditunjukkan pada method show() yang digunakan di berbagai class dengan kebutuhan yang berbeda-beda dengan nama yang sama.
3. Abstraction : class Abstarct ditunjukkan pada Abstact class admin yang di-extends pada class EditorScreen. Adapun Interface terdapat pada Interface Show yang di-implements pada beberapa class yaitu class AdminLoginScreen, class AdminScreen, dan class LoginScreen. Abstraction juga diterapkan dengan menyembunyikan detail koneksi database di dalam metode getConnection(), sehingga user tidak perlu tahu bagaimana cara menghubungkan ke database.
4. Encapsulation : ditunjukkan pada class Foods dimana atribut-atributnya di-enkapsulasi dalam bentuk private, sehingga hanya dapat diakses menggunakan method setter-getter.

## Mentoring
1. Jum'at, 24 Mei 2023
2. Rabu, 29 Mei 2024

## Link Repository GitHub
https://github.com/AorusGit/Foodies.git

## Screenshots
### Main Menu Scene
![MainMenuScreen](https://github.com/AorusGit/Foodies/assets/144238044/898d4e0d-c1eb-40e9-85a8-81aa9338394b)

### User Scene
![UserScreen](https://github.com/AorusGit/Foodies/assets/144238044/60093a13-d368-4e22-93f9-5d614369e157)

### FnB Menu  
![FoodMenuScreen](https://github.com/AorusGit/Foodies/assets/144238044/a13bc1ea-a92a-4c9e-a28b-2f961c91b098)

### Deskripsi Menu Scene
![FoodDetailScreen](https://github.com/AorusGit/Foodies/assets/144238044/c3dcc8ea-2110-4f92-a4de-19365baeae5d)

### Login Menu Scene
![SignInMenu](https://github.com/AorusGit/Foodies/assets/144238044/ec67c6f4-18ee-4ede-9689-7bf5a97d25d3)

### Admin Menu Scene
![AdminPage1](https://github.com/AorusGit/Foodies/assets/144238044/c0591cbf-f43b-47dd-a08a-5cbb92fffdff)

### Edit Menu Scene
![EditMenuScene](https://github.com/AorusGit/Foodies/assets/144238044/30d095cb-2be6-4cec-9c5d-361287d2f6f3)

## Pengujian Aplikasi
![UjiCoba1](https://github.com/AorusGit/Foodies/assets/144238044/1475660d-b527-4d1c-86e7-331393d460f0)
![UjiCoba2](https://github.com/AorusGit/Foodies/assets/144238044/52802e35-d9bd-4479-a5ee-8a9ff48b7f6c)

