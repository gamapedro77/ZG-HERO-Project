package Application.useCases.SearchByEmail

class SearchByEmailController {
    def searchUseCase

    SearchByEmailController(searchUseCase) {
        this.searchUseCase = searchUseCase
    }

    def handle() {
        // check if user has permissions to execute and then execute
        searchUseCase.execute()
    }
}
