package Application.useCases.SearchByEmail

class SearchByEmailController {
    def searchUseCase

    SearchByEmailController(searchUseCase) {
        this.searchUseCase = searchUseCase
    }

    def handle(String email) {
        // check if user has permissions to execute and then execute
        return searchUseCase.execute(email)
    }
}
