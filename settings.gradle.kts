rootProject.name = "jaicf-kotlin-external"

include(":jaicf-zb-api")
findProject(":jaicf-zb-api")?.name = "jaicf-zb-api"

include(":examples:jaicf-zb-api-example")
findProject("examples:jaicf-zb-api-example")?.name = "jaicf-zb-api"

