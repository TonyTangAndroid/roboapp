package nl.jovmit.roboapp.search

import nl.jovmit.roboapp.search.data.SearchState

class Repository(
  private val availableValues: List<String>
) {

  fun performSearch(query: String): SearchState {
    return if (availableValues.any { it.contains(query, true) }) {
      val match = availableValues.first { it.contains(query, true) }
      SearchState.Match(match)
    } else {
      SearchState.NoMatchFor(query)
    }
  }
}