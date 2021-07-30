import org.dif.didcomm.types.Attachment
import org.dif.didcomm.types.AttachmentData
import org.dif.didcomm.types.Message
import org.junit.Test

class MessageBuilderTest {
    companion object {
        val ALICE_DID = "did:example:alice"
        val BOB_DID = "did:example:bob"
        val CAROL_DID = "did:example:carol"

        val PAYLOAD = mapOf(
            "aaa" to 1,
            "bbb" to 2
        )
    }

    @Test
    fun buildMessage() {
        val message = Message.builder()
            .id("1234567890")
            .type("my-protocol/1.0")
            .from(ALICE_DID)
            .to(listOf(BOB_DID, CAROL_DID))
            .body(PAYLOAD)
            .createdTime(1516269022)
            .expiresTime(1516385931)
            .build()
    }

    @Test
    fun buildMessageWithAttachments() {
        val attachments = listOf(
            Attachment.builder()
                .id("123")
                .filename("test.txt")
                .data(AttachmentData.builder().links(listOf("1", "2")))
                .build(),

            Attachment.builder()
                .id("123")
                .filename("test.txt")
                .data(AttachmentData.builder().jwe("1234"))
                .build()
        )

        val message = Message.builder()
            .id("1234567890")
            .type("my-protocol/1.0")
            .from(ALICE_DID)
            .to(listOf(BOB_DID, CAROL_DID))
            .body(PAYLOAD)
            .createdTime(1516269022)
            .expiresTime(1516385931)
            .attachments(attachments)
            .build()
    }
}