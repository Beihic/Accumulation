function assert($one, $two){
	$expected = $one
	$input = $two

	./9cc $input tmp.s
	gcc tmp.s -o tmp 
	./tmp
	$actual = $LASTEXITCODE

	if($actual -eq $expected){
		echo "$input => $actual"
	} else {
		echo "$input => $expected expected, but got $actual"
	}
}

assert 0 0
assert 42 42

echo OK
