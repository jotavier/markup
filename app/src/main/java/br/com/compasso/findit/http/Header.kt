package br.com.compasso.findit.http

abstract class Header {
    companion object {
        const val ACCEPT = "Accept"
        const val CONTENT_TYPE = "Content-Type"
    }

    abstract class Type {
        companion object {
            const val APPLICATION_JSON = "application/json"
        }
    }
}