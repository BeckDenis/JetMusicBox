package denis.beck.jetmusicbox.data

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object AuthDataSerializer : Serializer<AuthData> {
    override val defaultValue: AuthData
        get() = AuthData()

    override suspend fun readFrom(input: InputStream): AuthData {
        try {
            return Json.decodeFromString(
                AuthData.serializer(), input.readBytes().decodeToString())
        } catch (serialization: SerializationException) {
            throw CorruptionException("Unable to read AuthDataPrefs", serialization)
        }
    }

    override suspend fun writeTo(t: AuthData, output: OutputStream) {
        output.write(Json.encodeToString(AuthData.serializer(), t).encodeToByteArray())
    }
}