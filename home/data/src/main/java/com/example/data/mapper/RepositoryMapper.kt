package com.example.data.mapper

import com.example.data.model.RepositoryResponse
import com.example.domain.model.Repository

fun RepositoryResponse.toDomainResponse(): Repository {
    return Repository(
        id = this.id,
        name = this.name,
        full_name = this.full_name,
        html_url = this.html_url,
        description = this.description,
        open_issues_count = this.open_issues_count
    )
}
/*
class RepositoryMapper : Mapper<RepositoryResponse, Repository> {
    override suspend fun map(from: RepositoryResponse): Repository {
        return Repository(
            id = from.id,
            name = from.name,
            full_name = from.full_name,
            html_url = from.html_url,
            description = from.description,
            open_issues_count = from.open_issues_count
        )
    }
}*/
