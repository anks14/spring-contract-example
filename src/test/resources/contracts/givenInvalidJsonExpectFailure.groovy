package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "When validation fails return Failure"

    request {
        method GET()
        urlPath("/testSchema") {
            queryParameters {
                parameter('shouldPassValidation', false)
            }
        }

    }
    response {
        body("Failure!")
        status 200
    }

}



