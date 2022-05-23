package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology",
          "contentText": "Ночь, улица, фонарь, аптека,
Бессмысленный и тусклый свет.
Живи еще хоть четверть века —
Все будет так. Исхода нет.

Умрешь — начнешь опять сначала
И повторится все, как встарь:
Ночь, ледяная рябь канала,
Аптека, улица, фонарь."
        }""".trimIndent())
        .setToken("dBajJypLRUWeMMfzrVoz-K:APA91bEoVX92-1Szm-_BRAEIIRd306-83mabjHwHT-l3hWOKPsDcha1mhVQ6X7Az3qRosiGKcLoAj3yFDxCQGXgEtkXvV6C33swlLnC6mxlkkOGn5bgv6JxeOAo4URBLKOsD01Ibp2js")
        .build()

    FirebaseMessaging.getInstance().send(message)
}
