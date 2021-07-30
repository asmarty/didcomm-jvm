import org.dif.didcomm.DIDComm
import org.dif.didcomm.types.*
import org.junit.Test

class DIDCommTest {
    companion object {
        val ALICE_DID = "did:example:alice"
        val BOB_DID = "did:example:bob"
        val CAROL_DID = "did:example:carol"

        val PAYLOAD = mapOf(
            "aaa" to 1,
            "bbb" to 2
        )
    }

    fun buildMessage(): Message {
        return Message.builder()
            .id("1234567890")
            .type("my-protocol/1.0")
            .from(ALICE_DID)
            .to(listOf(BOB_DID, CAROL_DID))
            .body(PAYLOAD)
            .createdTime(1516269022)
            .expiresTime(1516385931)
            .build()
    }

    @Test()
    fun sign() {
        DIDComm().sign(
            buildMessage(),
            ALICE_DID
        )
    }

    @Test()
    fun anonCrypt() {
        DIDComm().anonCrypt(
            buildMessage(),
            ALICE_DID,
            listOf(BOB_DID),
            AnonEncAlg.A256CBC_HS512_ECDH_ES_A256KW
        )
    }

    @Test()
    fun authCrypt() {
        DIDComm().authCrypt(
            buildMessage(),
            ALICE_DID,
            listOf(BOB_DID),
            AuthEncAlg.A256CBC_HS512_ECDH_1PU_A256KW
        )
    }

    @Test()
    fun anonAuthCrypt() {
        DIDComm().anonAuthCrypt(
            buildMessage(),
            ALICE_DID,
            listOf(BOB_DID),
            AnonEncAlg.A256CBC_HS512_ECDH_ES_A256KW,
            AuthEncAlg.A256CBC_HS512_ECDH_1PU_A256KW
        )
    }

    @Test()
    fun authCryptSigned() {
        DIDComm().authCryptSigned(
            buildMessage(),
            ALICE_DID,
            ALICE_DID,
            listOf(BOB_DID),
            AuthEncAlg.A256CBC_HS512_ECDH_1PU_A256KW
        )
    }

    @Test()
    fun anonAuthCryptSigned() {
        DIDComm().anonAuthCryptSigned(
            buildMessage(),
            ALICE_DID,
            ALICE_DID,
            listOf(BOB_DID),
            AnonEncAlg.A256CBC_HS512_ECDH_ES_A256KW,
            AuthEncAlg.A256CBC_HS512_ECDH_1PU_A256KW
        )
    }

    @Test()
    fun parse() {
        DIDComm().parse("")
    }

    @Test()
    fun forward() {
        DIDComm().forward("", ALICE_DID, AnonEncAlg.A256CBC_HS512_ECDH_ES_A256KW)
    }

    @Test()
    fun parseForward() {
        DIDComm().parseForward("")
    }
}