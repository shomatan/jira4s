package tech.ignission.jira4s.v3.apis

import tech.ignission.jira4s.v3.Credentials
import tech.ignission.jira4s.v3.datas.{IdParam, IdOrKeyParam, Project, Component}
import tech.ignission.jira4s.v3.dsl.BacklogHttpDsl.Response
import tech.ignission.jira4s.v3.dsl.{HttpDSL, HttpQuery}

class ComponentAPI[F[_]](baseUrl: String, credentials: Credentials)(implicit httpDSL: HttpDSL[F]) {
  import tech.ignission.jira4s.v3.formatters.SprayJsonFormats._

  private val resource = s"/rest/api/3"

  def all(projectIdOrKey: IdOrKeyParam[Project]): F[Response[Seq[Component]]] =
    httpDSL.get[Seq[Component]](
      HttpQuery(
        path = s"$resource/project/$projectIdOrKey/components",
        credentials = credentials,
        baseUrl = baseUrl
      )
    )

  def get(id: IdParam[Component]): F[Response[Component]] =
    httpDSL.get[Component](
      HttpQuery(
        path = s"$resource/component/${id.toString}",
        credentials = credentials,
        baseUrl = baseUrl
      )
    )
}
