package scanner.client

import common.domain.MavenArtifactImpl
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json

class JBossClient(
  url: String,
  override val client: HttpClient,
  override val json: Json,
) : AnchorClient<MavenArtifactImpl>(url) {
  override fun String.isBackLink(): Boolean = equals("Parent Directory", true)
}
