package contracts

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "When a employee is created return Success"
    request{
        method GET()
        url("/testSchema")

    }
    response {
        body(false)
        status 200
    }
}