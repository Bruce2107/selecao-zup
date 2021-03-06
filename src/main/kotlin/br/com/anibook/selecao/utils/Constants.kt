package br.com.anibook.selecao.utils

class Constants {
    companion object {
        private const val URL_API_BASE = "/api"
        private const val VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + VERSION
        const val URL_BASE_PERSON = "$URL_BASE/person"
        const val NOT_FOUND = "Person no found"
    }
}