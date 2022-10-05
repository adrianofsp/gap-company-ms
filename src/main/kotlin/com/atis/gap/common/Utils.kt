//import io.micronaut.core.annotation.Introspected
//import org.slf4j.LoggerFactory
//import java.util.Optional
//import java.util.UUID
//
//
//private val logger = LoggerFactory.getLogger("UtilsKt")
//
//
//object HeadersKey {
//    const val USER_OPERATION = "user-operation"
//}
//
//
//interface ErrorType {
//    fun getType(): Pair<String, String>
//}
//
//
//enum class OperationResultEnum: ErrorType {
//    MISSING_HEADER { override fun getType() = ("400-001" to "Chave no header não informada ou vazia") },
//    INVALID_PAYLOAD { override fun getType() = ("400-002" to "O payload informado é inválido.") },
//    INVALID_ATTRIBUTE { override fun getType() = ("400-003" to "O objeto informado possui um atributo inválido.") },
//    NO_CONTENT { override fun getType() = ("204-001" to "O objeto informado não foi encontrado.") },
//    DUPLICATE_ELEMENT { override fun getType() = ("406-001" to "O objeto informado está duplicado.") }
//}
//
//data class ResponseError (
//    val code: String,
//    val message: String,
//    val reason: String? = null
//)
//
//
////@Introspected
////data class PaginationCommand (
////    val max: Int = -1,
////    val offset: Int = 0
////)
//
////fun <T, E: IIdentifier<*>> httpResponse(id: T, getById: (T) -> Optional<E>): MutableHttpResponse<*> {
////    val optionalEntity = getById(id)
////
////    return if(!optionalEntity.isEmpty) {
////        HttpResponse.ok(when(val entity = optionalEntity.get()) {
////            is StepTemplate -> entity.toDto()
////            is Step -> entity.toDto()
////            is Tracking -> entity.toDto()
////            else -> throw Exception("Tipo não definido para conversão de resposta da consulta")
////        })
////    } else HttpResponse.noContent<Unit>()
////
////}
//
//
////fun <T: IIdentifier<*>, E: IIdentifier<*>> httpResponse(entityIn: T, update: (T) -> E?): MutableHttpResponse<*> {
////    val entity = update(entityIn)
////    return if(entity != null) {
////
////        HttpResponse.ok(when(entity) {
////            is StepTemplate -> entity.toDto()
////            is Step -> entity.toDto()
////            is Tracking -> entity.toDto()
////            else -> throw Exception("Tipo não definido para conversão de resposta da atualização")
////        })
////
////    } else HttpResponse.noContent<Unit>()
////}
//
////fun <E: IIdentifier<UUID>> List<E>.httpResponse(): MutableHttpResponse<List<E>>
////= when(this.isNotEmpty()) {
////    true -> HttpResponse.ok(this)
////    else -> HttpResponse.noContent()
////}
////
//
////fun  Boolean.httpResponse(): MutableHttpResponse<String>
////    = when(this) {
////    true -> HttpResponse.ok("OK")
////    else -> HttpResponse.noContent()
////}
//
//
//internal inline infix fun <T, V: IIdentifier<UUID>> T.executeCreate(block: T.() -> V)
//        = runCatching { block() }
//    .onSuccess {
//        logger.overallSuccess (
//            message = "${it::class.simpleName} criado com sucesso.",
//            content = mapOf(
//                PAYLOAD to it
//            ),
//            METHOD to "executeCreate"
//        )
//    }
//    .getOrThrow()
//
//internal inline infix fun <T, V: IIdentifier<UUID>> T.executeUpdate(block: T.() -> V)
//        = runCatching { block() }
//    .onSuccess {
//        logger.overallSuccess (
//            message = "${it::class.simpleName} alterado com sucesso.",
//            content = mapOf(
//                PAYLOAD to it
//            ),
//            METHOD to "executeUpdate"
//        )
//    }
//    .getOrThrow()
//
//
//internal inline infix fun <T, V: List<IIdentifier<UUID>>> T.executeList(block: T.() -> V)
//        = runCatching { block() }
//    .onSuccess {
//        logger.overallSuccess (
//            message = "${it::class.simpleName} listado com sucesso.",
//            content = emptyMap(),
//            METHOD to "executeList",
//            RETURNED_ITENS_COUNT to it.size
//        )
//    }
//    .getOrThrow()
//
//internal inline infix fun <T, V: IIdentifier<UUID>> T.executeGet(block: () -> Optional<V>)
//        = runCatching { block() }
//    .onSuccess {
//        logger.overallSuccess (
//            message = "${it::class.simpleName} obtido com sucesso.",
//            content = mapOf(
//                PAYLOAD to it
//            ),
//            METHOD to "executeGet"
//        )
//    }
//    .getOrThrow()
//
//
//internal inline infix fun <T, V> T.executeDelete(block: T.() -> V)
//        = runCatching { block() }
//    .onSuccess {
//        if(it == true){
//            logger.overallSuccess (
//                message = "Item deletado com sucesso.",
//                content = emptyMap(),
//                METHOD to "executeDelete"
//            )
//        }
//        else{
//            logger.warn(
//                "Item não encontrado."
//            )
//        }
//    }
//    .getOrThrow()
//
//
//
//inline fun <E: IIdentifier<*>, T> List<E>.runEntityMapping(transform: () -> T) = runCatching {
//    transform()
//
//}.onFailure {
//    throw it
//}
//
//
//inline fun <E: IIdentifier<*>?, T> E.runEntityMapping(transform: () -> T) = runCatching {
//    transform()
//}.onFailure {
//    throw it
//}
//
//
//inline fun <E: IIdentifier<*>?, T> Optional<E>.runEntityMapping(transform: () -> T) = runCatching {
//    transform()
//}.onFailure {
//    throw it
//}
