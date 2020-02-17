package company.opendoor.phone;

/**
 * # Baby Names
 * # Description
 * # Build a baby names search engine.
 * #
 * # We collected baby names from various published lists and put them into a JSON object as follows:
 * #
 * # key: source list name (e.g. "2015-us-official-boys", "2015-baby-center-girls")
 * # value: a list of names in the order of popularity (e.g. [ "SOPhia", "Emma", "Olivia", ... ])
 * # baby-names-data.json
 * #
 * # {
 * #   "2016-baby-center-girls": [ "Sophia", "Emma", "Olivia", ... ],
 * #   "2016-baby-center-boys": [ "Jackson", "Aiden", "Lucas", ...],
 * #   "2015-baby-center-girls": [ "Sophia", "Emma", "Olivia", ... ],
 * #   ...
 * # }
 * # The question has two parts:
 * #
 * # Write a function that given a name, returns an ascending rank sorted list of names of all lists where the given name appears.
 * #
 * # For example, given "sophia", function returns:
 * #
 * #  [
 * #    {list: "2016-baby-center-girls", rank: 1},
 * #    {list: "2015-baby-center-girls", rank: 1},
 * #    {list: "2015-us-official-girls", rank: 3}
 * #  ]
 * #
 * # Now, we would like to make our service more user friendly. We would like to provide a name prefix (e.g. "an") and get all baby names that start with that prefix (e.g. "anna", "anthony", etc.) along with the list name and relative ranking for each matching name.
 * #
 * # For example, given "an", function returns something like this:
 * #
 * # {
 * #   anna: [
 * #     { list: '2015-baby-center-girls', rank: 36 },
 * #     { list: '2016-baby-center-girls', rank: 46 }
 * #   ],
 * #   andrew: [
 * #     { list: '2015-baby-center-boys', rank: 44 },
 * #     { list: '2016-baby-center-boys', rank: 47 }
 * #   ],
 * #   anthony: [
 * #     { list: '2015-baby-center-boys', rank: 48 }
 * #   ]
 * # }
 */
public class BabyName {
}
