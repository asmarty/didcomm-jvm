package org.dif.didcomm.types

enum class TYP(typ: String) {
    Encrypted("application/didcomm-encrypted+json"),
    Signed("application/didcomm-signed+json"),
    Plaintext("application/didcomm-plain+json"),
}

class AttachmentData(
    val jws: String?,
    val hash: String?,
    val links: List<String>?,
    val base64: String?,
    val jwe: String?,
    val json: Map<String, Any>?
) {
    private constructor(builder: Builder) : this(
        builder.jws,
        builder.hash,
        builder.links,
        builder.base64,
        builder.jwe,
        builder.json,
    )

    class Builder {
        var jws: String? = null
            private set

        var hash: String? = null
            private set

        var links: List<String>? = null
            private set

        var base64: String? = null
            private set

        var jwe: String? = null
            private set

        var json: Map<String, Any>? = null
            private set

        fun jws(value: String) = apply { this.jws = value }
        fun hash(value: String) = apply { this.hash = value }
        fun links(value: List<String>) = apply { this.links = value }
        fun base64(value: String) = apply { this.base64 = value }
        fun jwe(value: String) = apply { this.jwe = value }
        fun json(value: Map<String, Any>) = apply { this.json = value }

        fun build() = AttachmentData(this)
    }

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }
}

class Attachment(
    val id: String,
    val filename: String,
    val lastModTime: Int,
    val data: AttachmentData,
    val description: String?,
    val mimeType: String?,
    val byteCount: Int?,
) {
    private constructor(builder: Builder) : this(
        builder.id,
        builder.filename,
        builder.lastModTime,
        builder.data,
        builder.description,
        builder.mimeType,
        builder.byteCount
    )

    class Builder {
        lateinit var id: String
            private set

        lateinit var filename: String
            private set

        lateinit var data: AttachmentData
            private set

        var lastModTime: Int = 0
            private set

        var description: String? = null
            private set

        var mimeType: String? = null
            private set

        var byteCount: Int? = null
            private set

        fun id(value: String) = apply { this.id = value }
        fun filename(value: String) = apply { this.filename = value }
        fun lastModTime(value: Int) = apply { this.lastModTime = value }
        fun data(value: AttachmentData.Builder) = apply { this.data = value.build() }
        fun description(value: String) = apply { this.description = value }
        fun mimeType(value: String) = apply { this.mimeType = value }
        fun byteCount(value: Int) = apply { this.byteCount = value }

        fun build() = Attachment(this)
    }

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }
}

class Message(
    val id: String,
    val body: Map<String, Any>,
    val type: String,
    val typ: TYP,
    val from: String?,
    val to: List<String>?,
    val createdTime: Int?,
    val expiresTime: Int?,
    val headers: Map<String, Any>?,
    val attachments: List<Attachment>?
) {
    private constructor(builder: Builder) : this(
        builder.id,
        builder.body,
        builder.type,
        builder.typ,
        builder.from,
        builder.to,
        builder.createdTime,
        builder.expiresTime,
        builder.headers,
        builder.attachments
    )

    class Builder {
        lateinit var id: String
        lateinit var body: Map<String, Any>
        lateinit var type: String
        lateinit var typ: TYP
        var from: String? = null
        var to: List<String>? = null
        var createdTime: Int? = null
        var expiresTime: Int? = null
        var headers: Map<String, Any>? = null
        var attachments: List<Attachment>? = null

        fun id(value: String) = apply { this.id = value }
        fun body(value: Map<String, Any>) = apply { this.body = value }
        fun type(value: String) = apply { this.type = value }
        fun typ(value: TYP) = apply { this.typ = value }
        fun from(value: String) = apply { this.from = value }
        fun to(value: List<String>) = apply { this.to = value }
        fun createdTime(value: Int) = apply { this.createdTime = value }
        fun expiresTime(value: Int) = apply { this.expiresTime = value }
        fun headers(value: Map<String, Any>) = apply { this.headers = value }
        fun attachments(value: List<Attachment>) = apply { this.attachments = value }

        fun build() = Message(this)
    }

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }
}