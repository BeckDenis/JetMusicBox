package denis.beck.jetmusicbox.extensions

/**
 * Returns all even values (in order, not index value!)
 *
 * Example: [1, 2, 3, 4] -> [2, 4]
 */
fun <T> Iterable<T>.even() = this.filterIndexed { index, _ -> index % 2 == 0 }

/**
 * Returns all odd values (in order, not index value!)
 *
 * Example: [1, 2, 3, 4] -> [1, 3]
 */
fun <T> Iterable<T>.odd() = this.filterIndexed { index, _ -> index % 2 != 0 }

/**
 * Returns values linked in pairs
 *
 * Example: [1, 2, 3, 4] -> [(1,2), (3,4)]
 */
fun <T> Iterable<T>.zipByPairs(): List<Pair<T, T>> = this.odd().zip(this.even())